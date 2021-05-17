import java.util.ArrayList;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

    public class Model implements Serializable {
        private ArrayList<Enter> entries;

        public ArrayList<Enter> getEntries() { return entries; }
        public Model() { this.entries = new ArrayList<>(); }

        public Enter createEnter(String body, String user,String datum,String id) {
            Enter enter = new Enter(body,user,datum,id);
            this.entries.add(enter);
            return enter;

        }
    }


