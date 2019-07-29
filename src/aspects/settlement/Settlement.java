import java.util.List;

public
 class Settlement
 extends RouteElement
 implements CanBeSaved
{ public final SettlementType type

; public Integer population
; public Float latitude
; public Float longitude;

  public
   Settlement
    ( String name
    , SettlementType type)
  { super(name)
  ; this.type = type; }

  @Override
  public
   void addRouteElement
    ( RouteElement routeElement)
  { Boolean isRoadSegment
     = routeElement
        instanceof
         RoadSegment

  ; if(isRoadSegment == false)
    { System.out.println
        (" Attempted to add invalid route element.")
    ; return; }

    super.addRouteElement
      ( routeElement); }

  public
   void setPopulation
    (Integer population)
  { this.population = population; }

  public
   void setLatLong
    ( float latitude
    , float longitude)
  { this.latitude = latitude
  ; this.longitude = longitude; }

  public
   SaveInstruction prepareSave()
  { SaveInstruction saveEntry
     = new SaveInstruction
        ("settlement", this.name)

  ; saveEntry.put
     ( this.toString())

  ; return saveEntry; }

  public
    String toString()
  { String soFar
     = super.toString()
  ; soFar += String.format
      ( "Population=%s\r\n"
       +"Kind=%s\r\n"
       +"Lat,Long=%s,%s\r\n"
      , this.population
      , this.type
      , this.latitude
      , this.longitude)
  ; return soFar; } }
