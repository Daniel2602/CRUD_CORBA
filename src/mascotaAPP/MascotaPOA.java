package mascotaAPP;


/**
* mascotaAPP/MascotaPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from mascota.idl
* lunes 14 de mayo de 2018 06:17:51 PM COT
*/

public abstract class MascotaPOA extends org.omg.PortableServer.Servant
 implements mascotaAPP.MascotaOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarMascota", new java.lang.Integer (0));
    _methods.put ("consultarMascota", new java.lang.Integer (1));
    _methods.put ("eliminarMascota", new java.lang.Integer (2));
    _methods.put ("actualizarMascota", new java.lang.Integer (3));
    _methods.put ("listarMascota", new java.lang.Integer (4));
    _methods.put ("shutdown", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // mascotaAPP/Mascota/insertarMascota
       {
         int id = in.read_long ();
         String nombreMascota = in.read_wstring ();
         String apellidoMascota = in.read_wstring ();
         String nombreDueno = in.read_wstring ();
         int telefonoDueno = in.read_long ();
         boolean $result = false;
         $result = this.insertarMascota (id, nombreMascota, apellidoMascota, nombreDueno, telefonoDueno);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // mascotaAPP/Mascota/consultarMascota
       {
         int id = in.read_long ();
         String $result = null;
         $result = this.consultarMascota (id);
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 2:  // mascotaAPP/Mascota/eliminarMascota
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.eliminarMascota (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // mascotaAPP/Mascota/actualizarMascota
       {
         int id = in.read_long ();
         String nombreMascota = in.read_wstring ();
         String apellidoMascota = in.read_wstring ();
         String nombreDueno = in.read_wstring ();
         int telefonoDueno = in.read_long ();
         boolean $result = false;
         $result = this.actualizarMascota (id, nombreMascota, apellidoMascota, nombreDueno, telefonoDueno);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // mascotaAPP/Mascota/listarMascota
       {
         String $result = null;
         $result = this.listarMascota ();
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 5:  // mascotaAPP/Mascota/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:mascotaAPP/Mascota:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Mascota _this() 
  {
    return MascotaHelper.narrow(
    super._this_object());
  }

  public Mascota _this(org.omg.CORBA.ORB orb) 
  {
    return MascotaHelper.narrow(
    super._this_object(orb));
  }


} // class MascotaPOA