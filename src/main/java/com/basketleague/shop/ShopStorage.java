package com.basketleague.shop;

import com.basketleague.model.ShopItem;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ShopStorage {

    private static final List<ShopItem> items = new ArrayList<>();
    private static final AtomicInteger ID = new AtomicInteger(1);

    static {
        items.add(new ShopItem(ID.getAndIncrement(), "Кепка Уникс", "https://sun9-34.userapi.com/s/v1/ig2/7AcAxnN2VtR8GpwsygPkQqQiCuLEvb4vLzw0ycqxX8TG2zUAQJI5AbHej0BobeCTsg-c3anjuxbPGjbTF8gAG9G7.jpg?quality=95&as=32x32,48x48,72x72,108x108,160x160,240x240,360x360,480x480,540x540,640x640,720x720,1080x1080&from=bu&u=_4mXsHqdk3sF2OUej1QzVyjzazwRwLoQffUfilXn-qE&cs=540x0", 2200));
        items.add(new ShopItem(ID.getAndIncrement(), "Форма Уникс", "https://sun9-44.userapi.com/s/v1/ig2/_Q6IxbYX-EMG87z1cSZt_n9PsD6jXb_QIRGGQlbQhB9r5ikyd1Ox48sjw8sIH3PqbZdYwjRH0O34Z5T1SpNqeH9v.jpg?quality=95&as=32x32,48x48,72x72,108x108,160x160,240x240,360x360,480x480,540x540,640x640,720x720,1080x1080&from=bu&u=F8FTMahx9rIbNB2FkqgdEmrt5CSI_3rigCIBBf9shQU&cs=540x0", 6000));
        items.add(new ShopItem(ID.getAndIncrement(), "Шарф Уникс", "https://sun9-77.userapi.com/s/v1/ig2/aPxX3DskxSwNS5MRQN26iKQtCRJS-RixCBSlRUjupI5OnouMnYqHaFbKZN97OwNAnm5EAHQ0tnQW4MORckgRvcyV.jpg?quality=95&as=32x32,48x48,72x72,108x108,160x160,240x240,360x360,480x480,540x540,640x640,720x720,1080x1080&from=bu&u=AgWoLzKF-YJwsKtvwLE3F5YKadTZK91B-NSv4Lzkbvc&cs=540x0", 1000));
    }

    public static List<ShopItem> getAll() {
        return items;
    }

    public static ShopItem getById(int id) {
        return items.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public static void add(String name, String image, int price) {
        items.add(new ShopItem(ID.getAndIncrement(), name, image, price));
    }

    public static void delete(int id) {
        items.removeIf(i -> i.getId() == id);
    }
}
