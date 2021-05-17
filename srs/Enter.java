
public class Enter {
        String id;
        String namn;
        String meddelande;
        String datum;

        public String getBody() {
            return id;
        }

        public String getDatum() {
            return namn;
        }

        public String getUser() {
            return meddelande;
        }

        public String getId() { return datum; }

        public Enter(String id, String namn, String meddelande, String datum) {
            this.id = id;
            this.namn = namn;
            this.meddelande=meddelande;
            this.datum= datum;
        }

    }

