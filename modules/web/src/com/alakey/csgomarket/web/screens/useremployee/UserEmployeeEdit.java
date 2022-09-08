package com.alakey.csgomarket.web.screens.useremployee;

import com.haulmont.cuba.gui.screen.*;
import com.alakey.csgomarket.entity.UserEmployee;

@UiController("csgomarket_UserEmployee.edit")
@UiDescriptor("user-employee-edit.xml")
@EditedEntityContainer("userEmployeeDc")
@LoadDataBeforeShow
public class UserEmployeeEdit extends StandardEditor<UserEmployee> {
}