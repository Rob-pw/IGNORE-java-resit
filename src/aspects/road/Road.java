public
 class Road
 extends RouteElement
 implements CanBeSaved
{ private
   RoadType type;

  public
   Road
    ( String name
    , RoadType type)
  { super(name)
  ; this.type = type; }

  public
   SaveInstruction prepareSave()
  { SaveInstruction saveEntry
     = new SaveInstruction
        ("road", this.name)

  ; saveEntry.put
     ( this.toString())

  ; return saveEntry; }

  public
   String toString()
  { return String.format
     ( "Name=%s\r\n"
      +"Type=%s\r\n"
     , this.name
     , this.type);} }
