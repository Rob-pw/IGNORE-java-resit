import java.util.HashMap;
import java.util.Map;

public
 class SaveInstruction
{ private
   String toSave
; public final
   String fileName;

  public
   SaveInstruction
    ( String type
    , String name)
  { this.fileName =
      type + "." + name; }

  public
   String
    getSaveEntry()
  { return this.toSave; }

  public
   void put
    ( String toSave)
  { this.toSave = toSave; } }
