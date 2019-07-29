import java.util.List;

public
 class Route
 implements CanBeSaved
{ private Settlement from
; private List<RoadSegment> segments
; private Settlement to
; private String name;

  public
   Route
    ( Settlement from
    , List<RoadSegment> segments
    , Settlement to )
  { this.from = from
  ; this.segments = segments
  ; this.to = to; }

  public
   void setName
    (String name)
  { this.name = name; }

  public
   Settlement getFrom()
  { return this.from; }

  public
   Settlement getTo()
  { return this.to; }

  public
   List<RoadSegment> getSegments()
  { return this.segments; }

  public
   SaveInstruction prepareSave()
  { SaveInstruction saveEntry
     = new SaveInstruction
        ("route", this.name)

  ; saveEntry.put
     ( this.toString())

  ; return saveEntry; }

  public
   String toString()
  { return String.format
     ( "Name=%s\r\n"
      +"Connectors=%s\r\n"
     , this.name
     , RouteConnections.list
        ( this.from
        , this.segments
        , this.to)); } }
