
// Información de un simbolo interviniente en el programa

public class Simbolo {

   private Etiqueta flag;  // clasificacion del simbolo	
   private String nombre;  // nombre del simbolo 
   private Etiqueta tipo;  // tipo del simbolo (int o boolean)
   private int valor;     //  valor asociado al simbolo (para int es un numero; para bool es true=0 y false=1

// constructores
    public Simbolo(Etiqueta flag) {
        this.flag = flag;
        this.nombre = "";
        this.tipo = Etiqueta.NOTTYPE;
        this.valor = 0;
    }
    
    public Simbolo(Etiqueta flag, String nombre, Etiqueta tipo, int valor) {
        this.flag = flag;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Etiqueta getEtiqueta() {
        return flag;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Etiqueta getTipo() {
        return tipo;
    }

    public void setTipo(Etiqueta tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public String toString(){
	    return "("+this.getEtiqueta()+" , "+this.getNombre()+" , "+this.getTipo()+" , "+this.getValor()+")\n";
	}     
    
}
