import java.util.ArrayList;

// Clase que representa las configuraciones de una aplicación.
class GestorAjustes {
    private int tamañoFuente = 12;
    private String tema = "claro";

    public GestorAjustes() {}

    public void cargar() {}
    public void guardar() {}

    public int getTamañoFuente() {}
    public void setTamañoFuente(int n) {}

    public String getTema() {}
    public void setTema(int n) {}
}

// Clase que representa una conexión a una base de datos.
class ConexionBd {
    private String strConn;
    private Connection conn;

    public ConexionBd(String pStrConn) {}

    public void connect() {}

    public Connection getConnection() {}

    public void disconnect() {}
}

// Clase que representa un registro de eventos de la aplicación.
// Versión previa a la aplicación del patrón singleton.
class RegistroEventosPrev {
    private ArrayList<String> eventos = new ArrayList<String>();

    public RegistroEventosPrev() {}

    public ArrayList<String> getEventos() {
      return eventos;
    }
    public void registrarEvento(String e) {
      eventos.add(e);
    }
}

// Clase que representa un registro de eventos de la aplicación.
// Versión posterior a la aplicación del patrón singleton.
class RegistroEventos {
    private ArrayList<String> eventos = new ArrayList<String>();
    private static RegistroEventos _instancia;

    protected RegistroEventos() {}

    public static RegistroEventos instancia() {
        if (_instancia == null) {
            _instancia = new RegistroEventos();
        }
        return _instancia;
    }

    public ArrayList<String> getEventos() {
      return eventos;
    }
    public void registrarEvento(String e) {
      eventos.add(e);
    }
}

class ModuloVentasPrev {
  private RegistroEventosPrev reg = new RegistroEventosPrev();
  public ModuloVentasPrev () {
    reg.registrarEvento("Instancia de ModuloVentas creada");
  }
}

class ModuloUsuariosPrev {
  private RegistroEventosPrev reg = new RegistroEventosPrev();
  public ModuloUsuariosPrev () {
    reg.registrarEvento("Instancia de ModuloUsuarios creada");
  }
}

class ModuloVentas {
  private RegistroEventos reg = RegistroEventos.instancia();
  public ModuloVentas () {
    reg.registrarEvento("Instancia de ModuloVentas creada");
  }
}

class ModuloUsuarios {
  private RegistroEventos reg = RegistroEventos.instancia();
  public ModuloUsuarios () {
    reg.registrarEvento("Instancia de ModuloUsuarios creada");
  }
}
