package BusReservUsingJDBC;

public class Bus {
   private int usNo;
   private boolean ac;
   private int Capacity;

   public Bus(int busNo, boolean ac, int capacity) {
      this.usNo = busNo;

      this.ac = ac;
      this.Capacity = capacity;

   }

   public int getBusNo() {
      return usNo;
   }

   public void setBusNo(int busNo) {
      usNo = busNo;
   }

   public boolean isAc() {
      return ac;
   }

   public void setAc(boolean ac) {
      this.ac = ac;
   }

   public int getCapacity() {
      return Capacity;
   }

   public void setCapacity(int capacity) {
      Capacity = capacity;
   }


}
