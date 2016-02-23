package com.fivido.sectionedexpandablegridlayout.adapters;

import com.fivido.sectionedexpandablegridlayout.models.Item;

/**
 * Created by lenovo on 2/23/2016.
 */
public interface ItemClickListener {
    void itemClicked(Item item);
    void itemClicked(Section section);
}
