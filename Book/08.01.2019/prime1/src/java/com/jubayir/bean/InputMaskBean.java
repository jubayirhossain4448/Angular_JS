
package com.jubayir.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class InputMaskBean {
    
    private String moblieNo;

    public String getMoblieNo() {
        return moblieNo;
    }

    public void setMoblieNo(String moblieNo) {
        this.moblieNo = moblieNo;
    }
    
    public void save(){
        System.out.println("Mobile No:" + moblieNo);
    }
}
