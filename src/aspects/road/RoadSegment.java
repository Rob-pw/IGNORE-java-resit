import java.lang.Math;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public
 class RoadSegment
 extends RouteElement
 implements CanBeSaved
{ private Float miles
; private Road road;

  public
   RoadSegment
    ( String segmentName)
  { super(segmentName); }

  public
   void setMiles
    ( Float miles)
  { this.miles = Math.abs(miles); }

  public
   void setRoad
    ( Road road)
  { this.road = road; }

  public
   String toString()
  { String soFar
     = super.toString()
  ; soFar += String.format
     ( "Length:%s\r\n"
      +"Road name:%s\r\n"
     , this.miles
     , Objects.isNull(this.road)
        ? "none"
        : this.road.name)
  ; return
     soFar; }

  public
   SaveInstruction prepareSave()
  { SaveInstruction saveEntry
     = new SaveInstruction
        ("roadSegment", this.name)

  ; saveEntry.put
     ( this.toString())

  ; return saveEntry; } }
