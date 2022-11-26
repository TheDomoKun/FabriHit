package what.a.fuck.domokun.fabrihit.managers;

public class HitBoxManager {

    public float size = 0;
    public boolean ph;

    public void inc(){
        size += 0.1;
    }
    public void reduce(){
        if(size > 0.1){
            size -= 0.1;
        }

    }

}
