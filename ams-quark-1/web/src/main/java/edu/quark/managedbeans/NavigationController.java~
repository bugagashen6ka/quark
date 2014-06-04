package ua.kpi.its.dspukhkaiev.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "navigationController")
@SessionScoped
public class NavigationController {

    private String page;

    public String moveToArea() {
        this.page = "/area.xhtml";
        return "success";
    }

    public String moveToRule() {
        this.page = "/rule.xhtml";
        return "success";
    }
    
    public String moveToCause(){
        this.page = "/cause.xhtml";
        return "success";
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

}
