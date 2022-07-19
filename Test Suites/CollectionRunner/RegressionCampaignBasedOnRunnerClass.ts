<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteCollectionEntity>
   <description>Regression Campaign</description>
   <name>RegressionCampaignBasedOnRunnerClass</name>
   <tag>regression</tag>
   <delayBetweenInstances>2</delayBetweenInstances>
   <executionMode>PARALLEL</executionMode>
   <maxConcurrentInstances>2</maxConcurrentInstances>
   <testSuiteRunConfigurations>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Mobile</groupName>
            <profileName>ROM</profileName>
            <requireConfigurationData>true</requireConfigurationData>
            <runConfigurationData>
               <entry>
                  <key>deviceName</key>
                  <value>iPhone iPhone 11 15.5</value>
               </entry>
               <entry>
                  <key>deviceId</key>
                  <value>00008030-00066C542682802E</value>
               </entry>
            </runConfigurationData>
            <runConfigurationId>iOS</runConfigurationId>
         </configuration>
         <runEnabled>true</runEnabled>
         <testSuiteEntity>Test Suites/RomTestSuite</testSuiteEntity>
      </TestSuiteRunConfiguration>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Mobile</groupName>
            <profileName>PL</profileName>
            <requireConfigurationData>true</requireConfigurationData>
            <runConfigurationData>
               <entry>
                  <key>deviceName</key>
                  <value>iPhone iPhone 13 mini 15.5</value>
               </entry>
               <entry>
                  <key>deviceId</key>
                  <value>00008110-0006409C3482801E</value>
               </entry>
            </runConfigurationData>
            <runConfigurationId>iOS</runConfigurationId>
         </configuration>
         <runEnabled>true</runEnabled>
         <testSuiteEntity>Test Suites/PlTestSuite</testSuiteEntity>
      </TestSuiteRunConfiguration>
   </testSuiteRunConfigurations>
</TestSuiteCollectionEntity>
