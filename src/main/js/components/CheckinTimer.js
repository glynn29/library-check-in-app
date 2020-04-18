import React from "react";

export class CheckinTimer extends React.Component{
    constructor(props) {
        super(props);
        this.state ={
            elapsedTime: 0,
            time:'',
        };
        this.startCounting = this.startCounting.bind(this);
        this.checkout = this.checkout.bind(this);
    }

    getSeconds(){
        return('0' + this.state.elapsedTime % 60).slice(-2);
    }
    getMinutes(){
        return(
            Math.floor(this.state.elapsedTime / 60)
        );
    }
    getHours(){
        return(
            Math.floor(this.state.elapsedTime / 3600)
        );
    }

    startCounting() {
        var _this = this;
        this.timer = setInterval(()=> {
            _this.setState({elapsedTime:(_this.state.elapsedTime + 1)})
        },1000)
    }

    checkout(){
        console.log("Checked Out");
        clearInterval(this.timer);
        this.setState({elapsedTime:0})
    }

    render() {
        return (
            <div>
                <h3>Time Studied:<h4>{this.getHours()}:{this.getMinutes()}:{this.getSeconds()}</h4></h3>
            </div>
        );
    }
}
