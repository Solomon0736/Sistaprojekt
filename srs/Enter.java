
public class Enter {
        String id;
        String namn;
        String meddelande;

        public String getBody() {
            return id;
        }

        public String getDatum() {
            return namn;
        }

        public String getUser() {
            return meddelande;
        }


        public Enter(String id, String namn, String meddelande) {
            this.id = id;
            this.namn = namn;
            this.meddelande=meddelande;
        }

    }

