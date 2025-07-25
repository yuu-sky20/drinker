# Drinker Web App

## What's this

- 簡易自動販売機を模したWebアプリケーション
- Spring WebFlux で実装
- GoFの理解のために作成

## design

### state

| 状態                | 説明         |
| ----------------- | ---------- |
| `IdleState`       | 入金待ち、初期状態  |
| `HasMoneyState`   | お金が投入された状態 |
| `SoldOutState`    | 在庫がないときの状態 |
| `DispensingState` | 商品を出している状態 |

### endpoint

| 要素        | 内容                                                       |
| --------- | -------------------------------------------------------- |
| エンドポイント | `GET /api/vending/state`                                 |
| 返す内容   | 現在の状態名（`IdleState`, `HasMoneyState`, `SoldOutState`, `DispensingState`） |

## LICENSE

- [MIT](LICENSE.md)
