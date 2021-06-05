public class Main {
        public static void main(String[] args) {
            seli seli= new seli();
            View view = new View();
            Model model= new Model();

            Controller controller= new Controller(view, seli, model);


        }
    }

