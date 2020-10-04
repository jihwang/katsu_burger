package com.katsuburger.webapp.repository;

import com.katsuburger.webapp.domain.Item;
import com.katsuburger.webapp.domain.Location;
import com.katsuburger.webapp.domain.MenuCategory;
import com.katsuburger.webapp.domain.MenuItem;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@AllArgsConstructor
public class SampleDataLoad {
    private static final Logger log = LoggerFactory.getLogger(SampleDataLoad.class);
    LocationRepository locationRepository;
    MenuItemRepository menuItemRepository;
    ItemRepository itemRepository;
    MenuCategoryRepository menuCategoryRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            log.info("STARTING SAMPLE DATABASE LOAD");
            initGeorgetown();
        };
    }
    private void initGeorgetown() {
        initItems();
        initBurgerCategory();
        Location georgetown = new Location();
        georgetown.setName("Georgetown");
        georgetown.setAddressLine1("6538 4th Ave S");
        georgetown.setCity("Seattle");
        georgetown.setState("CA");
        georgetown.setZip("98108");
        georgetown.setPhoneNumber("(206) 762-0752");
        georgetown.setDoordashURL("https://www.doordash.com/business/12917/?utm_source=partner-link&utm_medium=website&utm_campaign=12917&utm_content=red-l");
        georgetown.setPickupURL("https://us.orderspoon.com/KatsuBurger");
        georgetown.setEnabled(true);
        georgetown.setMenu(menuCategoryRepository.findAll());
        log.info("LOADING: " + locationRepository.save(georgetown));
    }
    private void initBurgerCategory() {
        MenuCategory burgers = new MenuCategory();
        burgers.setName("Burgers");
        burgers.setDescription("ALL BURGERS COME COMPLETE WITH PICKLES, RED ONION, TOMATO, & SHREDDED CABBAGE\n");

        MenuItem tokyoClassic = new MenuItem();
        tokyoClassic.setPrice(8.95f);
        tokyoClassic.setVisible(true);
        tokyoClassic.setItem(itemRepository.findById("Tokyo Classic").orElseThrow());
        MenuItem ninjaDeluxe = new MenuItem();
        ninjaDeluxe.setPrice(10.00f);
        ninjaDeluxe.setVisible(true);
        ninjaDeluxe.setItem(itemRepository.findById("Ninja Deluxe").orElseThrow());
        List<MenuItem> items = Arrays.asList(new MenuItem[] {tokyoClassic, ninjaDeluxe});
        burgers.setMenuItems(items);
        log.info("LOADING: " + menuItemRepository.saveAll(items));
        log.info("LOADING: " + menuCategoryRepository.save(burgers));
    }

    private void initItems() {
        Item tokyoClassic = new Item();
        tokyoClassic.setName("Tokyo Classic");
        tokyoClassic.setDescription("The Original. Have it Simple or build your own. Grass Fed beef Katsu, Tonkatsu Sauce, Japanese Mayo");

        Item fries12Spice = new Item();
        fries12Spice.setName("12 Spice fries");
        fries12Spice.setDescription("Spicy!~ Lightly salted fries are sprinkled with house-made 12 spices for the perfect balance of spiciness and a hint of sweetness!");

        Item banzaiBites = new Item();
        banzaiBites.setName("Banzai Bites");
        banzaiBites.setDescription("Fun-snack size chicken strips or pork bites.");

        Item ninjaDeluxe = new Item();
        ninjaDeluxe.setName("Ninja Deluxe");
        ninjaDeluxe.setDescription("Crispy Natural Pork Loin Katsu, Cheddar Cheese, Bacon,  Tonkatsu Sauce, Japanese Mayo");

        log.info("LOADING: " + itemRepository.saveAll(Arrays.asList(new Item[] {tokyoClassic, fries12Spice, banzaiBites, ninjaDeluxe})));
    }

}
