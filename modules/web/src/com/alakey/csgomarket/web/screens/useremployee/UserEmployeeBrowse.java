package com.alakey.csgomarket.web.screens.useremployee;

import com.haulmont.cuba.gui.screen.*;
import com.alakey.csgomarket.entity.UserEmployee;

@UiController("csgomarket_UserEmployee.browse")
@UiDescriptor("user-employee-browse.xml")
@LookupComponent("userEmployeesTable")
@LoadDataBeforeShow
public class UserEmployeeBrowse extends StandardLookup<UserEmployee> {
}