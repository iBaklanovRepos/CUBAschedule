package com.company.schedule.web.screens.classroom;

import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Classroom;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@UiController("schedule_Classroom.edit")
@UiDescriptor("classroom-edit.xml")
@EditedEntityContainer("classroomDc")
@LoadDataBeforeShow
public class ClassroomEdit extends StandardEditor<Classroom> {
    @Subscribe("room_type_picker")
    public void onRoom_type_pickerValueChange(HasValue.ValueChangeEvent<String> event) {
        if(Objects.equals(room_type_picker.getValue(), "Laboratory")){
            capacityField.setValue(1);
            capacityField.setEditable(false);
            capacityField.setDescription("Only one group may be placed in laboratory");
        }else {
            capacityField.setEditable(true);
            capacityField.setDescription("");
        }
    }
    @Inject
    private LookupField<String> room_type_picker;
    @Inject
    private TextField<Integer> capacityField;

    @Subscribe
    public void onInit(InitEvent event) {
        ArrayList<String> roomTypes = new ArrayList<>();
        roomTypes.add("Lecture");
        roomTypes.add("Laboratory");
        room_type_picker.setOptionsList(roomTypes);
    }


}