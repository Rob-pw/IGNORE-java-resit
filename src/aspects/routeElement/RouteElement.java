import java.util.List;
import java.util.ArrayList;

public abstract
 class RouteElement
{ public final
   String name
; protected
   List<RouteElement> elements;

  public
   RouteElement
    ( String name)
  { this.name = name
  ; this.elements
      = new ArrayList<RouteElement>(); }

  public
   void addRouteElements
     ( List<? extends RouteElement> routeElements)
  { for(RouteElement
      element : routeElements)
    { addRouteElement
        ( element); } }

  public
   void addRouteElement
    ( RouteElement routeElement)
  { this.elements.add
      ( routeElement); }

  public
   RouteElement[]
    getRouteElements()
  { return
      this.elements.toArray
        ( new RouteElement
           [this.elements.size()]); }

  public static
   void connect
    ( List<RouteElement> elements
    , RouteElement connect)
  { for(RouteElement
      element : elements)
    { element.addRouteElement
        ( connect); } }

  public
   String toString()
  { return String.format
     ( "Name=%s\r\n"
      +"Connectors=%s\r\n"
     , this.name
     , RouteConnections.stringify
        ( this.elements)); } }
