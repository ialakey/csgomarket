package com.alakey.csgomarket.web.screens.cases;

import com.haulmont.cuba.gui.screen.*;
import com.alakey.csgomarket.entity.Case;

@UiController("csgomarket_Case.edit")
@UiDescriptor("case-edit.xml")
@EditedEntityContainer("caseDc")
@LoadDataBeforeShow
public class CaseEdit extends StandardEditor<Case> {
}