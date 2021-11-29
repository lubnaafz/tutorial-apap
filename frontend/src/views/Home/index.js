import React from "react";
import List from "../../components/List/index";
import listItems from "../../items.json";
import "./index.css";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Fab } from "@material-ui/core";
import ViewStreamIcon from '@mui/icons-material/ViewStream';
import Theme from "../../components/Theme/index";


export default class Home extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            shopItems: listItems,
            cartItems: [],
            cartHidden: true,
            balance: 120,
            theme: "Light"
        };
    }

    handleAddItemToCart = (item) => {
        const newItems = Object.values([...this.state.cartItems]);
        const newItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        if(targetInd < 0){
            newItem.inCart = true;
            newItems.push(newItem);
            this.handleBalance(newItem, true);
            this.updateShopItem(newItem, true)
        }
        this.setState({ cartItems: newItems });
    };

    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        this.setState({ shopItems: tempShopItems });
    }

    handleDeleteItemFromCart = (item) => {
        const tempCartItems = Object.values([...this.state.cartItems]);
        const delItem = { ...item };
        const targetInd = tempCartItems.findIndex((it) => it.id === delItem.id);
        tempCartItems.splice(targetInd,1);
        this.addItemToList(delItem);
        this.setState({ cartItems: tempCartItems });
    };

    addItemToList = (item) => {
        const tempItems = Object.values([...this.state.shopItems]);
        const delItem = { ...item };
        const targetInd = tempItems.findIndex((it) => it.id === delItem.id);
        tempItems[targetInd].inCart = false;
        this.handleBalance(delItem, false);
        this.setState({ shopItems: tempItems });

    }

    handleBalance = (item, inCart) => {
        const getItem = {...item};
        const balance = this.state.balance - getItem.price;

        if(inCart){
            if(balance < 0){
                alert('Balance not sufficient!');
                this.setState({balance : this.state.balance - getItem.price})
            }
            this.setState({balance : this.state.balance - getItem.price})
        }else{
            this.setState({balance : this.state.balance + getItem.price})
        }
    }

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
    }

    toggleDark = () => {

    }

    render() {
        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                        {this.state.cartHidden ?
                            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                                <ShoppingCartIcon/>
                            </Badge>
                            : <ViewStreamIcon/>}
                    </Fab>
                </div>
                <p className="text-center text-secondary text-sm font-italic">
                    (this is a <strong>class-based</strong> application)
                </p>
                <p className="text-center text-primary"> Your Balance: <b> {this.state.balance} </b></p>
                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <List
                                    /*title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={() => {}}*/
                                    title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={this.handleDeleteItemFromCart}
                                    isShopList={false}
                                ></List>
                            </div>
                        ) : <div className="col-sm">
                            <List
                                title="List Items"
                                items={this.state.shopItems}
                                onItemClick={this.handleAddItemToCart}
                                isShopList={true}
                            ></List>
                        </div>}
                    </div>
                </div>
            </div>
        );
    }

}
