import java.util.Objects;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public
 class RouteParser
{ private Application app;

  public
   RouteParser
    ( Application app)
  { this.app = app; }

  public
   Route parse
    ( String routePath)
  { List<String> parts
     = new LinkedList<String>
        (Arrays.asList
          (routePath.split(":")) )

  ; String fromSettlementName
     = parts.remove(0)
  ; Settlement fromSettlement
     = findRouteElement
        ( this.app.settlements
        , fromSettlementName)

  ; if(Objects.isNull(fromSettlementName))
    { return this.bail
        ("invalid FROM settlement"); }

  ; String toSettlementName
     = parts.remove(parts.size() - 1)
  ; Settlement toSettlement
     = findRouteElement
        ( this.app.settlements
        , toSettlementName)

  ; if(Objects.isNull(toSettlement))
    { return this.bail
        ( "invalid TO settlement"); }

  ; List<RoadSegment> segments
     = new ArrayList<RoadSegment>()
  ; for(String
      part : parts)
    { RoadSegment roadSegment
       = findRouteElement
          ( this.app.roadSegments
          , part)

    ; if(Objects.isNull(roadSegment))
      { return this
         . bail("invalid road segment"); }

    ; segments.add(roadSegment); }

  ; RouteValidation validation
     = new RouteValidation()
  ; Route route
     = validation.validate
        ( fromSettlement
        , segments
        , toSettlement)

  ; if(Objects.isNull(route))
    { return this.bail
        ( "invalid route, route has unconnected elements"); }

  ; return route; }

  private
    Route bail
     ( String message)
  { CliSelector
     . say(message)
  ; return null; }

  private <T extends RouteElement>
   T findRouteElement
    ( List<T> elements
    , String name)
  { for(RouteElement
      routeElement : elements)
    { String routeElementName
       = routeElement.name
    ; if(routeElementName.equals(name))
        return (T)routeElement; }

    return null; } }
