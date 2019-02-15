
package com.jubayir.textarea;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;

@ManagedBean
public class InputTextAreaView {
     
    public List<String> completeArea(String query) {
        List<String> results = new ArrayList<String>();
         
        if(query.equals("PrimeFaces")) {
            results.add("PrimeFaces Rocks!!!");
            results.add("PrimeFaces has 100+ components.");
            results.add("PrimeFaces is lightweight.");
            results.add("PrimeFaces is easy to use.");
            results.add("PrimeFaces is developed with passion!");
        }
        else {
            for(int i = 0; i < 10; i++) {
                results.add(query + i);
            }
        }
         
        return results;
    }
}
