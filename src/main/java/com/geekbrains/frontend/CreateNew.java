package com.geekbrains.frontend;

import com.geekbrains.entities.Category;
import com.geekbrains.entities.New;
import com.geekbrains.entities.Product;
import com.geekbrains.repositories.NewRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;

@Route("create-new")
public class CreateNew extends AbstractView {

    private final NewRepository newRepository;

    public CreateNew(NewRepository newRepository){
        this.newRepository = newRepository;
        initNewView();

    }

    private void initNewView() {
        TextField headerTextField = initTextFieldWithPlaceholder("Заголовок");
        TextField titleTextField = initTextFieldWithPlaceholder("Содержание");


        Button saveButton = new Button("Сохранить", event -> {
            New newItem = new New();
            newItem.setTitle(titleTextField.getValue());
            newItem.setHeader(headerTextField.getValue());

            newRepository.save(newItem);
            UI.getCurrent().navigate("news");
        });

        Button backButton = new Button("Назад", event -> {
            UI.getCurrent().navigate("market");
        });

        add(headerTextField, titleTextField,  saveButton, backButton);
    }



}
