class Base1 {
        private void amethod(int iBase) {
        System.out.println("Base.amethod");
        }
    }
    class Over extends Base1 {
        public static void main(String argv[]) {
        Over o = new Over();
        int iBase=0;
        o.amethod(iBase);
        }

        public void amethod(int iOver) {
        System.out.println("Over.amethod");
        }
    }
