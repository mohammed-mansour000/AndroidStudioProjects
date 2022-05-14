import 'package:flutter/material.dart';

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  final TextEditingController _nameController = new TextEditingController();
  final TextEditingController _passwordController = new TextEditingController();

  String userInfo = "";

  void onLogin(){
    setState(() {
      if(!_nameController.text.trim().isEmpty && !_passwordController.text.trim().isEmpty){  //trim to clear spaces
        print("name is empty");
        userInfo = '${_nameController.text.toString()} \n ${_passwordController.text.toString()}';
      }else{
        userInfo = "fill all fields";
      }
    });
  }

  void onClear(){
   setState(() { //use when u want to change in UI
     _nameController.clear();
     _passwordController.clear();
   });
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
        backgroundColor: Colors.deepOrange,
        centerTitle: true,
      ),
      body: Container(
        padding: EdgeInsets.all(25),
        alignment: Alignment.center,
        child: ListView(

          children: <Widget>[
            Image.asset("img/download.png",width: 150,height: 150,),
            Container(
              width: 250,
              padding: EdgeInsets.all(20),
              child:TextField(
                style: TextStyle(color: Colors.deepOrange),
                controller: _nameController,
                decoration: InputDecoration(
                    icon: Icon(Icons.person,color: Colors.deepOrange),
                    hintText: "Enter Your Name"
                ),
              ),
            ),
            Container(
              width: 250,
              padding: EdgeInsets.all(20),
              child:TextField(
                style: TextStyle(color: Colors.deepOrange),
                controller: _passwordController,
                obscureText: true,
                decoration: InputDecoration(
                    icon: Icon(Icons.lock,color: Colors.deepOrange),
                    hintText: "Enter Your Password"
                ),
              ),
            ),

            Center(
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                //crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Container(child:
                    RaisedButton(
                      onPressed: onLogin,
                      textColor: Colors.white,
                      color: Colors.deepOrange,
                      child: Text("login",),
                    ),
                  ),
                  Container(
                    margin: EdgeInsets.only(left: 45),
                    child:
                    RaisedButton(
                      onPressed: onClear,
                      textColor: Colors.white,
                      color: Colors.deepOrange,
                      child: Text("clear",),
                    ),
                  )
                ],
              )
            ),

            Center(
             child:
                 Container(
                   padding: EdgeInsets.only(top: 30),
                   child: Text("$userInfo",style: TextStyle(color: Colors.deepPurple,fontSize: 18),),
                 )
            )

          ],
        ),
      ),
    );
  }
}