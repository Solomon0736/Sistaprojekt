import java.util.ArrayList;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

    public class Model implements Serializable {
        private ArrayList<Enter> entries;

        public ArrayList<Enter> getEntries() { return entries; }
        public Model() { this.entries = new ArrayList<>(); }

        public Enter createEnter(String id, String namn, String meddelande) {
            Enter enter = new Enter(id,namn,meddelande);
            this.entries.add(enter);
            return enter;

        }
    }


