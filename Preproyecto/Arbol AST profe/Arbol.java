public class Arbol {

   private Simbolo info;
   private Arbol HI;
   private Arbol HD;
   private int id;

   static int idNro = 0;

   public Arbol(Simbolo s) {

      info = s;
      HI = null;
      HD = null;
      id = idNro;
      idNro += 1;
   }

   public Arbol(Simbolo s, Arbol hi, Arbol hd) {
      info = s;
      HI = hi;
      HD = hd;
      id = idNro;
      idNro += 1;
   }

   public int getId() {
      return id;
   }

   public Simbolo getInfo() {
      return info;
   }

   public Arbol getHD() {
      return HD;
   }

   public Arbol getHI() {
      return HI;
   }

   // metodo para recorrer el arbol y compara los nodos
   public Simbolo checkType() {
      Simbolo S1 = null;
      Simbolo S2 = null;

      if (this.getInfo().getEtiqueta() == Etiqueta.PROGRAMA) {
         HI.checkType();
         HD.checkType();
         return this.getInfo();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.SENTS) {
         HI.checkType();
         if (HD != null)
            HD.checkType();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.DECLS) {
         HI.checkType();
         if (HD != null)
            HD.checkType();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.DECLARACION) {
         S1 = HI.checkType();
         S2 = HD.checkType();
         if (S1.getTipo() == S2.getTipo()) {
            this.getInfo().setTipo(S1.getTipo());
            return this.getInfo();
         } else {
            System.out.println("Error de tipos en la declaracion");
            System.exit(0);
         }
      } else if (this.getInfo().getEtiqueta() == Etiqueta.ASIGNACION) {
         S1 = HI.checkType();
         S2 = HD.checkType();
         if (S1.getTipo() == S2.getTipo()) {
            return this.getInfo();
         } else {
            System.out.println("Error de tipos en la asignacion");
            System.exit(0);
         }
      } else if (this.getInfo().getEtiqueta() == Etiqueta.SUMA) {
         S1 = HI.checkType();
         S2 = HD.checkType();
         if (S1.getTipo() == S2.getTipo()) {
            this.getInfo().setTipo(S1.getTipo());
            return this.getInfo();
         } else {
            System.out.println("Error de tipos en la suma");
            System.exit(0);
         }
      } else if (this.getInfo().getEtiqueta() == Etiqueta.MULT) {
         S1 = HI.checkType();
         S2 = HD.checkType();
         if (S1.getTipo() == S2.getTipo()) {
            this.getInfo().setTipo(S1.getTipo());
            return this.getInfo();
         } else {
            System.out.println("Error de tipos en la multiplicacion");
            System.exit(0);
         }
      } else if (this.getInfo().getEtiqueta() == Etiqueta.VALORBOOLEANO) {
         return this.getInfo();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.VALORENTERO) {
         return this.getInfo();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.VARIABLE) {
         return this.getInfo();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.RETURN) {
         HI.checkType();

      }
      return null;
   }

   // Evaluador del arbol
   public Simbolo evaluador() {
      Simbolo S1 = null;
      Simbolo S2 = null;

      if (this.getInfo().getEtiqueta() == Etiqueta.PROGRAMA) {
         HI.evaluador();
         HD.evaluador();
         return this.getInfo();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.SENTS) {
         HI.evaluador();
         if (HD != null)
            HD.evaluador();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.DECLS) {
         HI.evaluador();
         if (HD != null)
            HD.evaluador();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.DECLARACION) {
         S1 = HI.evaluador();
         S2 = HD.evaluador();
         S1.setValor(S2.getValor());
         return S1;
      } else if (this.getInfo().getEtiqueta() == Etiqueta.ASIGNACION) {
         S1 = HI.evaluador();
         S2 = HD.evaluador();
         S1.setValor(S2.getValor());
         return S1;
      } else if (this.getInfo().getEtiqueta() == Etiqueta.SUMA) {
         S1 = HI.evaluador();
         S2 = HD.evaluador();
         if (this.getInfo().getTipo() == Etiqueta.INT) {
            this.getInfo().setValor(S1.getValor() + S2.getValor());
            return this.getInfo();
         } else if (this.getInfo().getTipo() == Etiqueta.BOOL) {
            this.getInfo().setValor(S1.getValor() + S2.getValor());
            return this.getInfo();
         }
      } else if (this.getInfo().getEtiqueta() == Etiqueta.MULT) {
         S1 = HI.evaluador();
         S2 = HD.evaluador();
         if (this.getInfo().getTipo() == Etiqueta.INT) {
            this.getInfo().setValor(S1.getValor() * S2.getValor());
            return this.getInfo();
         } else if (this.getInfo().getTipo() == Etiqueta.BOOL) {
            this.getInfo().setValor(S1.getValor() * S2.getValor());
            return this.getInfo();
         }
      } else if (this.getInfo().getEtiqueta() == Etiqueta.VALORBOOLEANO) {
         return this.getInfo();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.VALORENTERO) {
         return this.getInfo();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.VARIABLE) {
         return this.getInfo();
      } else if (this.getInfo().getEtiqueta() == Etiqueta.RETURN) {
         HI.evaluador();
         System.out.println("El valor de retorno es: " + HI.getInfo().getValor());
         return HI.getInfo();
      }
      return null;
   }

   public String toString() {
      String result = "( Nodo: "+id +" - "+info.toString()+" - ";
      if (HI!=null) result = result + "HI : "+ HI.getId()+" - ";
      if (HD!=null) result = result + "HD : "+ HD.getId();
      result+=" )\n";
      if (HI!=null) result = result + HI.toString();
      if (HD!=null) result = result + HD.toString();
      return result;
   }
}
