package com.alakey.csgomarket.web.screens.cases;

import com.haulmont.cuba.gui.screen.*;
import com.alakey.csgomarket.entity.Case;

@UiController("csgomarket_Case.browse")
@UiDescriptor("case-browse.xml")
@LookupComponent("casesTable")
@LoadDataBeforeShow
public class CaseBrowse extends StandardLookup<Case> {
}