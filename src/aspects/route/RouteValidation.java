import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public
 class RouteValidation
{ public
   Route validate
    ( Settlement fromSettlement
    , List<RoadSegment> segments
    , Settlement toSettlement)
  { List<RouteElement>
      routeElements
       = RouteConnections.combine
          ( fromSettlement
          , segments
          , toSettlement)
  ; Integer count
     = routeElements.size()

  ; for
      ( int i = 0
      ; i < count - 1
      ; i += 1)
    { RouteElement target
       = routeElements.get(i)
    ; RouteElement maybeConnected
       = routeElements.get(i + 1)

    ; Boolean isConnected
       = this.elementIsConnected
          ( target
          , maybeConnected)

    ; if(!isConnected)
      { return null; } }

    return new
     Route
      ( fromSettlement
      , segments
      , toSettlement); }

  public
   Boolean elementIsConnected
    ( RouteElement target
    , RouteElement maybeConnected)
  { RouteElement[] elements
     = target.getRouteElements()
  ; for(RouteElement
      element : elements)
    { Boolean match
       = maybeConnected.equals(element)
    ; if(match)
      { return true; } }

  ; return false; } }
