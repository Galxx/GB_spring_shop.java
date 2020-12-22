package com.geekbrains.frontend;

import com.geekbrains.entities.New;
import com.geekbrains.repositories.NewRepository;
import com.geekbrains.repositories.ProductRepository;
import com.geekbrains.services.CartService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.router.Route;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Route("news")
public class NewView extends AbstractView {

    private final NewRepository newRepository;

    public NewView( NewRepository newRepository) {
        this.newRepository = newRepository;
        initNewView();
    }

    private void initNewView(){

        List<New> newList =  newRepository.findAll();
        for (New newItem: newList) {
            add(new Details(newItem.getHeader(),
                    new Text(newItem.getTitle())));
        }

    }

}
