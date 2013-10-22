package org.programa.rimas;

/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Demonstrates expandable lists backed by a Simple Map-based adapter
 */
public class ListaExpandible extends ExpandableListActivity {
    private static final String PALABRA = "PALABRA";
    private static final String DEFINICION = "DEFINICION";
    
    private ExpandableListAdapter mAdapter;
    
    
    /* ********************************************************************************************************************************************
	 * P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ----
	 * 
	 * Hay que crear un SETTER para mandarle a la clase: 
	 *       - el Nº de palabras que riman, con la palabra buscada, 
	 *       - las palabras
	 *       - las definiciones  ( P E N D I E N T E)
	 *
	 * P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- 
	 * ********************************************************************************************************************************************/
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();
        /*
         * Numero de palabras que riman con la búsqueda.
         */
        for (int i = 0; i < 20; i++) {
            Map<String, String> curGroupMap = new HashMap<String, String>();
            groupData.add(curGroupMap);
            curGroupMap.put(PALABRA, "Palabra " + i);
            curGroupMap.put(DEFINICION, "definicion por el momento, definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,");
            
            List<Map<String, String>> children = new ArrayList<Map<String, String>>();
           
            Map<String, String> curChildMap = new HashMap<String, String>();
            children.add(curChildMap);
            curChildMap.put(PALABRA, "Significado");
            curChildMap.put(DEFINICION, "definicion por el momento, definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,definicion por el momento,");
            
            childData.add(children);
        }
        
        // Set up our adapter
        mAdapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                new String[] { PALABRA, DEFINICION },
                new int[] { android.R.id.text1, android.R.id.text2 },
                childData,
                android.R.layout.simple_expandable_list_item_2,
                new String[] { PALABRA, DEFINICION },
                new int[] { android.R.id.text1, android.R.id.text2 }
                );
        setListAdapter(mAdapter);
    }

}
