package com.wisstudio.recruit.vo;

import java.util.Map;

/**
 * @Author:98333
 * @Date:2021/4/29
 * @Description:com.wisstudio.recruit.vo
 */
public class ModelAndView {
    private Map<String, Object> model ;
    private String view;

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public ModelAndView(Map<String, Object> model, String view) {
        this.model = model;
        this.view = view;
    }

    public ModelAndView(String View) {
        this.view = View;
    }

}
