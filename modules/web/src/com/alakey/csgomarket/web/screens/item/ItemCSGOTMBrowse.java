package com.alakey.csgomarket.web.screens.item;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.screen.*;
import com.alakey.csgomarket.entity.Item;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UiController("csgomarket_ItemCSGOTM.browse")
@UiDescriptor("item-csgotm-browse.xml")
@LookupComponent("itemsTable")
@LoadDataBeforeShow
public class ItemCSGOTMBrowse extends StandardLookup<Item> {
    @Inject
    private DataManager dataManager;

    final String pricesUrl = "https://market.csgo.com/api/v2/prices/USD.json";

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ItemBrowse.class);

    @Install(to = "itemsDl", target = Target.DATA_LOADER)
    private List<Item> billsDlLoadDelegate(LoadContext<Item> loadContext) {
        return getItemCSGOTM();
    }

    private List<Item> getItemCSGOTM() {
        List<Item> items = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(pricesUrl)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            items = getInfoFromJson(responseData);
        } catch (IOException e) {
            log.error("Error", e);
        }
        return items;
    }

    private List<Item> getInfoFromJson(String responseData) {
        List<Item> itemList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(responseData);
        JSONArray jsonArrayResults = jsonObject.getJSONArray("items");

        for (int i=0; i<jsonArrayResults.length(); i++) {
            JSONObject jObjectResult = jsonArrayResults.getJSONObject(i);

            String hashName = jObjectResult.getString("market_hash_name");
            String sellPriceText = jObjectResult.getString("price");
            String volume = jObjectResult.getString("volume");


            Item item = dataManager.create(Item.class);
            item.setHashName(hashName);
            item.setSellPriceText(sellPriceText);
            item.setVolume(volume);

            itemList.add(item);
        }
        return itemList;
    }

}