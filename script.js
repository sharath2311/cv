/*var a,b,c,d;
a=78;
b=1.69;
c=92;
d=1.95;

var mB=a/(b*b);
var jB=c/(d*d);
if(mB>jB)
{
    var r=true;
}
console.log(mB,jB);
console.log('mark bmi is higher than john?'+r);


function addNumber(a,b)
{
    var c;
    c=a+b;
    return c;
}

var ans=addNumber(10,20);
console.log(ans);

var sha= 5>3?'Yes':'No';
console.log(sha);

var a1=124;
var b1=48;
var c1=268;

function tipCalculator(q,w,e)
{
    var li=new Array();
    //var lk=new Array();
    if(q<50 || w<50|| e<50)
    {
        var f=0.20;
        m=f*q;
        n=f*w;
        b=f*e;
        q=q+(f*q);
        w=w+(f*w);
        e=e+(f*e);
    }
    else if((q>=50 &&q<=200)||(w>=50 &&w<=200)||(e>=50 &&e<=200))
    {
        var g=0.15;
        m=g*q;
        n=g*w;
        b=g*e;
        q=q+(g*q);
        w=w+(g*w);
        e=e+(g*e);
    }
    else{
        var h=0.10;
        m=h*q;
        n=h*w;
        b=h*e;
        q=q+(h*q);
        w=w+(h*w);
        e=e+(h*e);
    }
    li.push(q);
    li.push(w);
    li.push(e);
    
    return li;
}
console.log(tipCalculator(b1,a1,c1));*/

/*var sharath={
    firstName: 'Sharath',
    year:1998,
    calAge:function()
    {
        return 2020-this.year;
    }

};

var age=(sharath.calAge(sharath.year));
sharath.bd=age;
console.log(sharath);*/

var john={
    fullName:'John Cena',
    mass:78,
    height:1.69,
    calcB:function(){
        return this.mass/(this.height*this.height);
        
    }
};

var mark={
    fullName:'Mark Henry',
    mass:68,
    height:1.19,
    calcB:function(){
        return this.mass/(this.height*this.height);
        
    }
};

john.bj=john.calcB();
mark.bm=mark.calcB();

if(john.bj>mark.bm)
{
    console.log(john.fullName+' has BMI of '+john.bj);
}
else{
    console.log(mark.fullName+' has BMI of '+mark.bm);
}
