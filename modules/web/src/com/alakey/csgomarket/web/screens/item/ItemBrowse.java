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

@UiController("csgomarket_Item.browse")
@UiDescriptor("item-browse.xml")
@LookupComponent("itemsTable")
@LoadDataBeforeShow
public class ItemBrowse extends StandardLookup<Item> {

    @Inject
    private DataManager dataManager;

    final String searchUrl = "https://steamcommunity.com/market/search/render/?search_descriptions=0&sort_column=default&sort_dir=desc&appid=730&norender=1&count=500";

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ItemBrowse.class);


    @Install(to = "itemsDl", target = Target.DATA_LOADER)
    private List<Item> billsDlLoadDelegate(LoadContext<Item> loadContext) {
        return getItem();
    }
    
    private List<Item> getItem() {
        List<Item> items = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(searchUrl)
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
        JSONArray jsonArrayResults = jsonObject.getJSONArray("results");

        for (int i=0; i<jsonArrayResults.length(); i++) {
            JSONObject jObjectResult = jsonArrayResults.getJSONObject(i);

            String name = jObjectResult.getString("name");
            String hashName = jObjectResult.getString("hash_name");
            String sellPriceText = jObjectResult.getString("sell_price_text");
            String salePriceName = jObjectResult.getString("sale_price_text");
            String appName = jObjectResult.getString("app_name");

            JSONObject jObject = jObjectResult.getJSONObject("asset_description");
            String iconUrl = jObject.getString("icon_url");
            String type = jObject.getString("type");

            Item item = dataManager.create(Item.class);
            item.setName(name);
            item.setHashName(hashName);
            item.setSellPriceText(sellPriceText);
            item.setSalePriceName(salePriceName);
            item.setAppName(appName);
            item.setIconUrl(iconUrl);
            item.setType(type);
            item.setAppId("730"); //Для CSGO

            itemList.add(item);
        }
        return itemList;
    }

}