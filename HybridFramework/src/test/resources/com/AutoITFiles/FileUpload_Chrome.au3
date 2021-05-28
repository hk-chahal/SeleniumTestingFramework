WinWaitActive("Open")
ControlFocus("Open", "", "Edit1")
ControlSetText("Open", "", "Edit1", $cmdLine[1])
ControlClick("Open", "", "Button1")