package an.object;

import org.springframework.stereotype.Service;

@Service
public class PageService {
    PageObject pageObject;
    public PageObject createService(PageObject pageObject){
        this.pageObject = pageObject;
        return this.pageObject;
    }
}
