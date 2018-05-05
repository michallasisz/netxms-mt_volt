//actual value of DCI
voltage_now = $1;                                                  
//read threshold from attributes(for that particular node)
threshold = GetCustomAttribute($node, "mt_ref_voltage_threshold");  

//it means it exist
if (threshold != null)                                              
{
    //if current voltage reading is less or equal threshold
    if (voltage_now <= threshold)                                   
    {
    	//threshold hitted, return true to create threshold activation event
      return true;                                                  
    }
    //everything else in reading (yeah I know:))
    else                                                            
    {
      //ok, deactivation event
      return false;                                                 
    }
}
