package bean;

import java.util.Date;

/**节日bean
 * Created by 九龙 on 2015/10/15.
 */
public class Festival {
    private  int id;//节日ID
    private String name;//节日名字
    private String desc;//节日描述
    private Date date;//节日日期
    public Festival(int id,String name){
            this.id=id;
            this.name=name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
