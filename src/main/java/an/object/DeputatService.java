package an.object;

import org.springframework.stereotype.Service;

@Service
public class DeputatService {
    DeputatObject deputatObject;
    public DeputatObject createService(DeputatObject deputatObject){
        this.deputatObject = deputatObject;
        return this.deputatObject;
    }
}
