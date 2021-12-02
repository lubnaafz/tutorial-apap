import React from "react";
import classes from "./styles.module.css";
import DeleteIcon from "@mui/icons-material/Delete";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import { IconButton } from "@material-ui/core";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Fab } from "@material-ui/core";
import ViewStreamIcon from '@mui/icons-material/ViewStream';

const Item = (props) => {
    const { item, onChange, isShopList } = props;
    const { id, title, price, description, category, quantity, handleEdit, handleDelete} = item;

    const handleChange = () =>
        !!onChange && onChange({ ...item, inCart: !inCart });

    return (
        <div
            className="list-group-item list-group-item-action d-flex align-items-center justify-content-between flex-row w-100 mb-3"
        >
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`Stok: ${quantity}`}</p>
        </div>
        <CustomIconButton isShopList={isShopList} inCart={inCart} handleChange={handleChange}/>
        </div>
    );
};
export default Item;

function CustomIconButton({ isShopList, inCart, handleChange }) {
    if(isShopList){
        if(inCart){
            return null;
        }
        return (
            <IconButton onClick={handleChange}>
                <AddShoppingCartIcon/>
            </IconButton>);
    }else{
        return (
            <IconButton onClick={handleChange}>
                {inCart ? <DeleteIcon /> : <AddShoppingCartIcon />}
            </IconButton>);
    }
}