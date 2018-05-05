if ($1 == null)
{
   println "Please specify node name as parameter";
   return 3;
}
 
transport = CreateSNMPTransport(FindObject($1));
if (transport == null)
{
    println "Failed to create SNMP transport, exit";
    return 1;
}
 
value = SNMPGetValue(transport, ".1.3.6.1.4.1.14988.1.1.3.8.0");
if (value == null)
{
    println "Failed to issue SNMP GET request";
    return 2;
}
else
{
    println "volt is: " . value;
    threshold = round(value - (0.15 * value));
    println "threshold for current reading will be: " . threshold;
    return 0;
}