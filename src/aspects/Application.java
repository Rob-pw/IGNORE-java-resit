import java.util.List;
import java.util.ArrayList;

public
 class Application
{ public ArrayList<Route> routes
; public List<Settlement> settlements
; public List<RoadSegment> roadSegments
; public List<Road> roads;

  public
   Application()
  { this.routes
     = new ArrayList<Route>()
  ; this.settlements
     = new ArrayList<Settlement>()
  ; this.roadSegments
     = new ArrayList<RoadSegment>()
  ; this.roads
     = new ArrayList<Road>(); } }
