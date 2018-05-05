if ($1 == null)
{
   println "Please specify node name as parameter";
   return 3;
}
$node = FindNodeObject(null,$1);

DeleteCustomAttribute($node, "mt_ref_voltage");
DeleteCustomAttribute($node, "mt_ref_voltage_threshold");