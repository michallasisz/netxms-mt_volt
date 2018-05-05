# netxms-mt_volt
Some things to remember:

-this is my way of doing that(some assumptions was taken from my previous NMS and topology).
 No guarantees...

-why I'm calculating threshold during first instance discovery instead of constant one?
 >different RB's(long time ago) gave me different readings of current voltage, even if they were
  connected to the same buffer power supply(one time difference was 8V )

-why 15 % threshold?
 >trial and error

-voltage 120 means 12.0V

-reference voltage must be aquired when batteries are fully charged

-if batteries are old and bad sometimes ap dies instantly without alarm. replace them to new ones:)

-time between power loss and alarm may vary depending on batteries condition, switching power supply 
 model etc.

 -remember to replug multimeters probes properly when you are using them for high current metering before :D
