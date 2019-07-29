import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.File;

public
 class ApplicationPersist
{ public
   void save
    (Application app)
  { save(app.settlements)
  ; save(app.roadSegments)
  ; save(app.routes)
  ; save(app.roads); }

  public
   void save
    (List<? extends CanBeSaved> listOfToBeSaved)
  { for(CanBeSaved
      toBeSaved : listOfToBeSaved)
    { save(toBeSaved); } }

  public
   void save
    ( CanBeSaved canBeSaved)
  { SaveInstruction saveInstruction
     = canBeSaved.prepareSave()
  ; saveInstruction(saveInstruction); }

  public
   void saveInstruction
    ( SaveInstruction saveInstruction)
  { String fileName
      = saveInstruction.fileName
  ; String filePath
     = "./data/" + fileName + ".txt"
  ; File file = new File(filePath);

    try
    { if (!file.exists()) file.createNewFile();
      else file.delete()

    ; PrintWriter writer = new PrintWriter(file)
    ; String saveEntry
       = saveInstruction.getSaveEntry()

    ; writer.println
        (saveEntry);

    ; writer.close(); }
    catch(Exception ex)
    { System.out.println(ex); } } }
