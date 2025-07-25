# Drinker Web App

## What's this

- 簡易自動販売機を模した Web アプリケーション
- Spring WebFlux で実装
- GoF の理解のために作成

## Try this app

1. ビルドしてローカルでアプリケーションを立ち上げる。次のシェルコマンドを実行: `./gradlew bootRun`
2. `http://localhost:8080` の各エンドポイントに対してリクエストを投げる

## Design

### commands

| コマンド             | 説明                               |
| -------------------- | ---------------------------------- |
| `BuyDrinkCommand`    | 商品を買う                         |
| `InsertMoneyCOmmand` | お金を投入する                     |
| `CancelCommand`      | 購入をキャンセルする（オプション） |

### state

| 状態              | 説明                 |
| ----------------- | -------------------- |
| `IdleState`       | 入金待ち、初期状態   |
| `HasMoneyState`   | お金が投入された状態 |
| `SoldOutState`    | 在庫がないときの状態 |
| `DispensingState` | 商品を出している状態 |

### endpoint

| エンドポイント                 | 返す内容                                                                        |
| ------------------------------ | ------------------------------------------------------------------------------- |
| `GET /api/vending/drink`       | 商品の一覧                                                                      |
| `GET /api/vending/state`       | 現在の状態名（`IdleState`, `HasMoneyState`, `SoldOutState`, `DispensingState`） |
| `POST /api/vending/buy/{name}` | `{name}` の商品を購入する                                                       |
| `POST /api/vending/cancel`     | 購入をキャンセルする                                                            |

## LICENSE

- [MIT](LICENSE.md)
